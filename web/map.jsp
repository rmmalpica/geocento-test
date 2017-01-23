<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="https://openlayers.org/en/v3.20.1/css/ol.css" type="text/css">
    <style>
      .map {
        height: 100%;
        width: 100%;
      }
    </style>
    <script src="https://openlayers.org/en/v3.20.1/build/ol.js" type="text/javascript"></script>
    <title>PNOA Images</title>
  </head>
  <body>    
    <div id="map" class="map"></div>
    <script type="text/javascript">
      
      var jsonIntersection = <%= request.getParameter("intersection") %>;
        
      var map = new ol.Map({
        target: 'map',
        layers: [
          new ol.layer.Tile({
            source: new ol.source.OSM()
          })
        ],
        view: new ol.View({
		  projection: "EPSG:4326",
         // center:  ol.proj.fromLonLat([-8.19042286901, 43.6633257059]),
		  center: [-8.19042286901, 43.6633257059],
          zoom: 7
        })
      });
	  
        var vectorSource = new ol.source.Vector({});      
          
        for(var i=0; i < jsonIntersection.length; i++)
        {
            var intersection = jsonIntersection[i];
            addExtent(vectorSource, intersection);
            addImage(map, intersection);
        }
        
        var layer = new ol.layer.Vector({
          source: vectorSource
        });  
        
        map.addLayer(layer);         	
          
          
        function addExtent(layer, intersection)
        {
            debugger;
            var coords = intersection.geomText.replace("POLYGON((","");
            coords = coords.replace("))","");
            
            coords = coords.split(",");
            
            var polCoords = [];
            
            for (var i = 0; i < coords.length; i++)
            {
                var coord = coords[i].split(" ");
                polCoords.push(coord);
                //var coord2 = coords[1].split(" ");
                //var coord3 = coords[2].split(" ");
                //var coord4 = coords[3].split(" ");
            }
            
         
            var polygon = new ol.geom.Polygon([polCoords]);

            // create some attributes for the feature
            var attributes = {area: intersection.area};
            
            var feature = new ol.Feature({
                geometry: polygon
            });                     
            
            vectorSource.addFeature(feature);           
        }
        
        function addImage(map, intersection)
        {
            debugger;
            var coords = intersection.imageGeom.replace("POLYGON((","");
            coords = coords.replace("))","");
            
            coords = coords.split(",");
            var coord1 = coords[0].split(" ");
            var coord2 = coords[1].split(" ");
            var coord3 = coords[2].split(" ");
            var coord4 = coords[3].split(" ");
            
            var extent = [coord4[0], coord4[1], coord2[0], coord2[1]];	
		
            var graphic = new ol.layer.Image({
                source: new ol.source.ImageStatic({
                url: 'images/' + intersection.imageName,
            //  imageSize: [1195, 609],
              //projection: projection,
              imageExtent: extent
            })
          })

          map.addLayer(graphic);
        }
	  
    </script>
  </body>
</html>