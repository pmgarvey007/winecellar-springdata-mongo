<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
	<link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/css/styles.css"/>'/>
	<title>Wine Cellar</title>
    <script type='text/javascript' src='<c:url value="/js/jquery-1.7.1.min.js"/>'></script>
	<script type='text/javascript'>
         var rootURL = '<%=request.getContextPath()%>/rest/wines';
         var urlURL = '<%=request.getRequestURL()%>';
         var uriURL = '<%=request.getRequestURI()%>';
         var pathURL = '<%=request.getServletPath()%>';
	</script>
    <script type='text/javascript' src='<c:url value="/js/main.js"/>'></script>

</head>

<body>

<div class="header">
	<input type="text" id="searchKey"/>
	<button id="btnSearch">Search</button>
	<button id="btnAdd">New Wine</button>
</div>


<div class="leftArea">
<ul id="wineList"></ul>
</div>

<form id="wineForm">

<div class="mainArea">

<label>Id:</label>
<input id="wineId" name="id" type="text" disabled />

<label>Name:</label>
<input type="text" id="name" name="name" required>

<label>Grapes:</label>
<input type="text" id="grapes" name="grapes"/>

<label>Country:</label>
<input type="text" id="country" name="country"/>

<label>Region:</label>
<input type="text" id="region" name="region"/>

<label>Year:</label>
<input type="text" id="year" name="year"/>

<button id="btnSave">Save</button>
<button id="btnDelete">Delete</button>

</div>

<div class="rightArea">

<img id="pic" height="300"/>

<label>Notes:</label>
<textarea id="description" name="description"></textarea>
</div>

</form>

<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>