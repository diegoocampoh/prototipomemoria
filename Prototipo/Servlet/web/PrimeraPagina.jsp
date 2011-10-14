<%-- 
    Document   : PrimeraPagina
    Created on : 02/10/2011, 11:10:45 AM
    Author     : Fran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <form action="/Servlet/Servletprueba" method="POST">

            <input id="Esc" type="checkbox" name="Escuelas" value="Escuelas">Escuelas </input>
            <input id="Pol" type="checkbox" name="Policia" value ="policias">Estacion Policias </input>
            <input id="Fab" type="checkbox" name="Fabrica" value ="fabricas">Fabricas </input>
            
                     <input type="text" name="id_lat" id="id_lat" />
                     <input type="text" name="id_lng" id="id_lng" />
                     <label for="id_lat">Centro</label>


                <p></p>

                    <input type="text" name="id_lat_sw" id="id_lat_sw" />
                    <input type="text" name="id_lng_sw" id="id_lng_sw" />
                    <label for="id_lat_sw">Esquina inferior izquierda</label>

                <p></p>


                    <input type="text" name="id_lat_ne" id="id_lat_ne" />
                    <input type="text" name="id_lng_ne" id="id_lng_ne" />
                    <label for="id_lat_sw">Esquina superior derecha</label>

                
            <input id="testo" type="text" name="testo"/>
            <!--input type="button" name="Consultar" value="Confirmar" onclick="consulta()"> </input-->
            <input type="submit" name="confirmar" onclick="consulta()"> </input>
  </form>
  </head>

  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">
  </script>
    <script type="text/javascript">
        function initialize() {
            var latlng = new google.maps.LatLng(-34.81115696,-56.1624207);
            var myOptions =
                {
                zoom: 11,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.SATELLITE
            };
            //google.maps.event.addListener(map, "move", function(){
                      document.getElementById("id_lat").value = map.getCenter().lat();
                      document.getElementById("id_lng").value = map.getCenter().lng();

                      document.getElementById("id_lat_sw").value = map.getBounds().getSouthWest().lat();
                      document.getElementById("id_lng_sw").value = map.getBounds().getSouthWest().lng();

                      document.getElementById("id_lat_ne").value = map.getBounds().getNorthEast().lat();
                      document.getElementById("id_lng_ne").value = map.getBounds().getNorthEast().lng();

                       marker.setLatLng(map.getCenter())
       // });
            var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
             //GEvent.addListener(map, "move", function() {
           
      //  map.getBounds().getSouthWest()



        }
    </script>
  <body>
    <h1> KML </h1>
     
            <div id="map_canvas" style="width:50%; height:50%">

            </div>
           <script type="text/javascript">
                var latlng = new google.maps.LatLng(-34.81115696,-56.1624207);
                var myOptions =
                    {
                    zoom: 11,
                    center: latlng,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                     var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                     var latSW = map.getBounds().getSouthWest().lat();
                     var lngSW = map.getBounds().getSouthWest().lng();
                     var latNE = map.getBounds().getNorthEast().lat();
                     var lngNE = map.getBounds().getNorthEast().lng();
                      //GEvent.addListener(map, "move", function() {
                     // google.maps.event.addListener(map, "move", function(){
                      
        //});
             function consulta(){
                        alert("Empezo");
                      document.getElementById("id_lat").value = map.getCenter().lat();
                      document.getElementById("id_lng").value = map.getCenter().lng();
                        alert("Termino3");
                      document.getElementById("id_lat_sw").value = map.getBounds().getSouthWest().lat();
                      document.getElementById("id_lng_sw").value = map.getBounds().getSouthWest().lng();
                          alert("Termino4");
                      document.getElementById("id_lat_ne").value = map.getBounds().getNorthEast().lat();
                      document.getElementById("id_lng_ne").value = map.getBounds().getNorthEast().lng();
                             alert("Termino5");
                       //marker.setLatLng(map.getCenter())
       //  });           alert("Termino");
                      //alert("Termino6");
                      document.getElementById("id_zoom").value = map.getZoom();
                      alert("Termino00");
       // GEvent.addListener(map, "zoomend", function() {
                     /// document.getElementById("id_zoom").value = map.getZoom();
                      
             };

                //var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                /*var marker = new google.maps.Marker({
                       position: latlng,
                       map: map,
    https://sites.google.com/site/kameleprototipo/kmlejemplo.kml
                       title:"Hello World!"
                });*/
                </script>

  </body>
</html>
