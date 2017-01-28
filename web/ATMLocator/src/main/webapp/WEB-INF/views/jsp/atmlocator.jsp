<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Google Maps Multiple Markers</title>
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/core/js/googlemap.js"></script>
</head>
<body>

	<spring:url value="/resources/core/css/hello.js" var="coreJs" />
	<spring:url value="/resources/core/css/bootstrap.min.js"
		var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


	<div class="jumbotron">
		<div class="container">
			<h1>${title}</h1>
			<p>
				<c:if test="${empty name}">
			       Welcome To The XYZ ATM Locator Service! )
		        </c:if>
			</p>
		</div>
	</div>

	<div class="container">
	    <div class="row">
	       <p>
			Search ATM:<spring:url value="/findatm" var="userActionUrl" />
			<form:form method="post" modelAttribute="findATMform"
				action="${userActionUrl}">
				Enter zip code:<form:input path="zipcode" type="text" />
				Optional:<br>
				longitude:<form:input path="lag" type="text" />
				latitude:<form:input path="lat" type="text" />
				<input type="submit" value="Submit" />
			</form:form>
			</p>
	    </div>
		<div class="row">
			<div class="col-md-4">
				<p>
				<div style="overflow-x: auto;">
					<div id="datalist"></div>
				</div>
				</p>
			</div>
			<div class="col-md-4">
				<p>
				<div id="map" style="width: 400px; height: 400px;"></div>
				</p>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		var json = ${mapResuls};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 12,
			center : new google.maps.LatLng(37.7749, -122.4194),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		var infowindow = new google.maps.InfoWindow();

		var marker, i;
		var test = 1;
		for (i = 0; i < json.length; i++) {
			var data = json[i];
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(data.lat, data.lng),
				map : map,
				title : data.title
			});
			var description = data.description;
			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent(json[i].description);
							infowindow.open(map, marker);
						}
					})(marker, i));
		}

		$(document)
				.ready(
						function() {
							var obj = ${mapResuls};
							var table = '<table border="1"><thead><th width="40%">Address</th><th>Description</th></thead><tbody>';
							//var obj = $.parseJSON(data);
							$.each(obj, function() {
								table += '<tr><td>' + this['title']
										+ '</td><td>' + this['description']
										+ '</td></tr>';
							});
							table += '</tbody></table>';
							document.getElementById("datalist").innerHTML = table;
						});
	</script>
</body>
</html>