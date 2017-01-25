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
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/core/js/googlemap.js"></script>
</head>
<body>
  XYZ Bank Locator
  --Div
	<div id="map" style="width: 500px; height: 400px;"></div>
	

	<script type="text/javascript">
    var locations = [
      ['XYZ ATM Bondi Beach', 37.776414, -122.451382, 4],
      ['XYZ ATM Coogee Beach', 37.790795, -122.413445, 5],
      ['XYZ ATM Cronulla Beach', 37.788353, -122.431469, 3],
      ['XYZ ATM Manly Beach', 37.799069, -122.405720, 2],
      ['XYZ ATM Maroubra Beach', 37.783469, -122.392845, 1]
    ];
    

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(37.7749, -122.4194),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>
</body>
</html>