<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_number</title>
</head>
<body>

  <c:set var="number" value="12345.6789" />

  <div>
    <fmt:formatNumber value="${number}" pattern="#,##0"></fmt:formatNumber>
  </div>
  <hr />
  <div>
    <fmt:formatNumber value="${number}" pattern="#,##0.00"></fmt:formatNumber>
  </div>
  <hr />
  <div>
    <fmt:formatNumber value="${number}" type="percent"></fmt:formatNumber>
  </div>
  <hr />
  <div>
    <fmt:formatNumber value="${number}" type="currency"></fmt:formatNumber>
  </div>  
  <hr />
  <div>
    <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"></fmt:formatNumber>
  </div>

</body>
</html>