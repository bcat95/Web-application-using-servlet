var map; // making it global
function initMap() {
    var myLatLng = {lat: 16.0474325, lng: 108.1712203};
    var thrLatLng = {lat: 14.0474325, lng: 108.1712203};
    var map = new google.maps.Map(document.getElementById('db-main-search-map'), {
      zoom: 5,
      center: myLatLng
    });
    var thrmarker1 = new google.maps.Marker({
      position: myLatLng,
      map: map,
      title: 'Hello World!'
    });
 }
var thrmarker2 = new google.maps.Marker({
    position: thrLatLng,
    map: map,
    title: 'Hello World!'
});