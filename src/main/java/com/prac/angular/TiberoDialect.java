package com.prac.angular;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.type.StandardBasicTypes;

public class TiberoDialect extends Oracle10gDialect
{
    public TiberoDialect()
    {
        super();
        registerHibernateType(Types.NVARCHAR, 4000, StandardBasicTypes.STRING.getName());
    }
}