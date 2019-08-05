<%@ tag display-name="Paginate Tag" description="Paginate Tag" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ attribute name="items" required="true" type="com.prac.angular.common.PaginatedList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${items.totalCount gt 0}">
	<script type="text/javascript">
		$(function(){
			$(".link_page").click(function(e){
				e.preventDefault();
				console.log("paginate.tag 클릭 인입 ==================");
				var page = $(this).attr("rel");
				if(page > 0){
					$.postURL("", {page:page});
				}
			});
		});
	</script>

	<div class="paging">
		<c:if test="${items.hasPrevUnit}">
			<a href="#" rel="${items.endPageOfPrevUnit}" class="link-page ico btn_page_frist"><i></i></a>
		</c:if>
		<span class="page_num">
		<c:forEach var="page" begin="${items.beginPage}" end="${items.endPage}">
			<c:choose>
				<c:when test="${page eq items.currentPage}">
					<a href="#" rel="0" class="link-page here">${page}</a>
				</c:when>
				<c:otherwise>
					<a href="#" rel="${page}" class="link-page">${page}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</span>
		<c:if test="${items.hasNextUnit}">
			<a href="#" rel="${items.beginPageOfNextUnit}" class="link-page ico btn_page_last"><i></i></a>
		</c:if>
	</div>

</c:if>