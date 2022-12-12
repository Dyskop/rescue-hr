<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="view" value="${requestScope.view}"/>
<c:set var="page" value="${requestScope.page}"/>
<c:set var="data" value="${requestScope.data}"/>
<c:set var="last" value="${requestScope.last}"/>
<c:set var="total" value="${requestScope.total}"/>
<c:choose>
    <c:when test="${view == 'users'}">
        <c:set var="path" value="${pageContext.request.contextPath}/users?page="/>
    </c:when>
    <c:when test="${view == 'employees'}">
        <c:set var="path" value="${pageContext.request.contextPath}/employees?page="/>
    </c:when>
    <c:when test="${view == 'search-line'}">
        <c:set var="path" value="${pageContext.request.contextPath}/search?data=${data}&page="/>
    </c:when>
    <c:when test="${view == 'ranks-log'}">
        <c:set var="path" value="${pageContext.request.contextPath}/rank-logs?page="/>
    </c:when>
    <c:when test="${view == 'positions-log'}">
        <c:set var="path" value="${pageContext.request.contextPath}/position-logs?page="/>
    </c:when>
</c:choose>
<c:if test="${pagination == true}">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:choose>
                <c:when test="${page == '1' && total == '2'}">
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 1}">${page + 1}</a></li>
                    <li class="page-item">
                        <a class="page-link" href="${path}${total}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${page == '1' && total == '3'}">
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 1}">${page + 1}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 2}">${page + 2}</a></li>
                    <li class="page-item">
                        <a class="page-link" href="${path}${total}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${page == '1'}">
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 1}">${page + 1}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 2}">${page + 2}</a></li>
                    <li class="page-item">
                        <a class="page-link" href="${path}${total}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${page == '2' && total == '2'}">
                    <li class="page-item">
                        <a class="page-link" href="${path}1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="${path}${page - 1}">${page - 1}</a></li>
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                </c:when>
                <c:when test="${page == total}">
                    <li class="page-item">
                        <a class="page-link" href="${path}1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="${path}${page - 2}">${page - 2}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page - 1}">${page - 1}</a></li>
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${path}1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="${path}${page - 1}">${page - 1}</a></li>
                    <li class="page-item active"><a class="page-link" href="${path}${page}">${page}</a></li>
                    <li class="page-item"><a class="page-link" href="${path}${page + 1}">${page + 1}</a></li>
                    <li class="page-item">
                        <a class="page-link" href="${path}${total}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</c:if>