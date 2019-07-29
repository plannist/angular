package com.prac.angular.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;
import com.prac.angular.common.Sort.Order;

@SuppressWarnings("PMD.AvoidInstantiatingObjectsInLoops")
public class Sort implements Iterable<Order>, Serializable
{

    private static final long     serialVersionUID  = 3871428012367434201L;

    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final List<Order>     orders;





    public Sort(final String... orders)
    {
        if ( orders == null || orders.length == 0 )
        {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = new ArrayList<Order>(orders.length);
        for ( String orderBy : orders )
        {
            if ( orderBy == null )
            {
                throw new IllegalArgumentException("Order is null");
            }

            orderBy = orderBy.trim();
            if ( orderBy.length() == 0 )
            {
                throw new IllegalArgumentException("Order is empty");
            }

            StringTokenizer orderByToken = new StringTokenizer(orderBy, ",");
            while ( orderByToken.hasMoreTokens() )
            {
                Direction direction;
                String property;

                String order = orderByToken.nextToken()
                                           .trim();
                int pos = order.lastIndexOf(' ');

                if ( pos == -1 )
                {
                    direction = DEFAULT_DIRECTION;
                    property = order;
                }
                else
                {
                    direction = Direction.fromString(order.substring(pos + 1));
                    property = order.substring(0, pos)
                                    .trim();
                }

                this.orders.add(new Order(direction, property));
            }
        }
    }





    public Sort(final Order... orders)
    {
        this(Arrays.asList(orders));
    }





    /**
     * Creates a new {@link Sort} instance.
     *
     * @param orders
     *            must not be {@literal null} or contain {@literal null} or empty strings
     */
    public Sort(final List<Order> orders)
    {
        if ( null == orders || orders.isEmpty() )
        {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = orders;
    }





    /**
     * Creates a new {@link Sort} instance.
     *
     * @param direction
     *            defaults to {@value Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties
     *            must not be {@literal null} or contain {@literal null} or empty strings
     */
    public Sort(final Direction direction, final String... properties)
    {
        this(direction, Arrays.asList(properties));
    }





    /**
     * Creates a new {@link Sort} instance.
     *
     * @param direction
     * @param properties
     */
    public Sort(final Direction direction, final List<String> properties)
    {
        if ( properties == null || properties.isEmpty() )
        {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<Order>(properties.size());
        for ( String property : properties )
        {
            this.orders.add(new Order(direction, property));
        }
    }





    /**
     * Return the reverse sort.
     */
    public Sort reverse()
    {
        List<Order> reversedOrders = new ArrayList<Order>(this.orders.size());
        for ( Order order : this.orders )
        {
            reversedOrders.add(order.with(order.isAscending() ? Direction.DESC : Direction.ASC));
        }
        return new Sort(reversedOrders);
    }





    @Override
    public Iterator<Order> iterator()
    {
        return this.orders.iterator();
    }





    @Override
    public boolean equals(final Object other)
    {
        if ( this == other )
        {
            return true;
        }
        if ( !(other instanceof Sort) )
        {
            return false;
        }

        Sort that = (Sort) other;
        return this.orders.equals(that.orders);
    }





    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + this.orders.hashCode();
        return result;
    }





    @Override
    public String toString()
    {
        return StringUtils.collectionToCommaDelimitedString(this.orders);
    }

    public static enum Direction
    {

        ASC,
        DESC;

        public static Direction fromString(final String value)
        {
            try
            {
                return Direction.valueOf(value.toUpperCase());
            }
            catch ( Exception e )
            {
                throw new IllegalArgumentException(String.format("Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }
    }

    public static class Order implements Serializable
    {
        private static final long serialVersionUID = 5334543343393987504L;

        private final Direction   direction;
        private final String      property;





        public static Order asc(final String property)
        {
            return new Order(Direction.ASC, property);
        }





        public static Order desc(final String property)
        {
            return new Order(Direction.DESC, property);
        }





        public Order(final Direction direction, final String property)
        {
            if ( property == null || "".equals(property.trim()) )
            {
                throw new IllegalArgumentException("Property must not null or empty!");
            }

            this.direction = direction == null ? DEFAULT_DIRECTION : direction;
            this.property = property;
        }





        public Order(final String property)
        {
            this(DEFAULT_DIRECTION, property);
        }





        public Direction getDirection()
        {
            return this.direction;
        }





        public String getProperty()
        {
            return this.property;
        }





        public boolean isAscending()
        {
            return this.direction.equals(Direction.ASC);
        }





        public Order with(final Direction direction)
        {
            return new Order(direction, this.property);
        }





        public Sort withProperties(final String... properties)
        {
            return new Sort(this.direction, properties);
        }





        @Override
        public int hashCode()
        {
            int result = 17;
            result = 31 * result + this.direction.hashCode();
            result = 31 * result + this.property.hashCode();
            return result;
        }





        @Override
        public boolean equals(final Object other)
        {
            if ( this == other )
            {
                return true;
            }
            if ( !(other instanceof Order) )
            {
                return false;
            }

            Order that = (Order) other;
            return this.direction.equals(that.direction) && this.property.equals(that.property);
        }





        @Override
        public String toString()
        {
            return String.format("%s: %s", this.property, this.direction);
        }
    }

}
