<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/core/js/googlemap.js"></script>
</head>
<body>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		<c:if test="${empty name}">
			Welcome XYZ ATM Locator Service!
		</c:if>
    </p>
    <p>
		<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
	</p>
	</div>
</div>

	<div class="container">
	    <div class="col-md-4">
			<p>ATM Location Details</p>
			<div style="overflow-x:auto;">
			  <div id="datalist"></div>
			</div>
		</div>
		<div id="map" style="width: 500px; height: 400px;"></div>
	</div>

	<script type="text/javascript">
    var json =${mapResuls};
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(37.7749, -122.4194),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;
    var test = 1;
    for (i = 0; i < json.length; i++) {  
    	var data = json[i];
        marker = new google.maps.Marker({
        position: new google.maps.LatLng(data.lat, data.lng),
        map: map,
        title: data.title
      });
      var description =data.description;
      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(json[i].description);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
    
    $(document).ready(function() {
        var obj = ${mapResuls};
        var table = '<table width="100%" border="1"><thead><th>Address</th><th>Review</th></thead><tbody>';
        //var obj = $.parseJSON(data);
        $.each(obj, function() {
            table += '<tr><td>' + this['title'] + '</td><td>' + this['description'] + '</td></tr>';
        });
        table += '</tbody></table>';
        document.getElementById("datalist").innerHTML = table;
    });
  </script>
</body>
</html>