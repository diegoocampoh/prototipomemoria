from pymaps import *
def enchulameEseMapa():

    
    #Las coordenadas las pueden obtener de Google Earth, por ejemplo
    coordenadasMontevideo = (-34.897352766562065, -56.165394720459) 
    
    mapa = PyMap()    
    iconPunto = Icon('iconPunto')
    iconPunto.image = "http://prototipomemoria.googlecode.com/svn-history/r10/trunk/Prototipo/iconos/factory.png"
    iconEscuela = Icon('iconEscuela')               # create an additional icon
    iconEscuela.image = "http://prototipomemoria.googlecode.com/svn-history/r10/trunk/Prototipo/iconos/school.png" # for testing only!
    
    mapa.addicon(iconPunto)
    mapa.addicon(iconEscuela)
    mapa.maps[0].center = coordenadasMontevideo   
    
    #Seteamos la clave de la api de Google Maps, ustedes pueden conseguir la suya gratis!
    mapa.key = "ABQIAAAAQQRAsOk3uqvy3Hwwo4CclBTrVPfEE8Ms0qPwyRfPn-DOTlpaLBTvTHRCdf2V6KbzW7PZFYLT8wFD0A" 
	
    #Acercamos un poquito
    mapa.maps[0].zoom = 11

    #Agrego un placemark (latitud, longitug, HTML)
    montevideo = [coordenadasMontevideo[0],coordenadasMontevideo[1],'<b>Montevideo, mi limpia y segura ciudad!!</b>']

    nombre_archivo = "data.csv"
    f = open(nombre_archivo,'r')
    for linea in f.readlines():
        linea_parseada = linea.split(';')
        if linea_parseada[2] == "":
            linea_parseada[2] = "Sin Nombre"
        html = ''
        for pedazo in linea_parseada[3:]:
            html = html+ str(pedazo)
        punto = [linea_parseada[1],linea_parseada[0],'<b>'+linea_parseada[2]+'</b>', linea_parseada[linea_parseada.__len__()-1]]
        mapa.maps[0].setpoint(punto)
    f.close()

   
    return mapa

#Metodo para escribir a un archivo, por defecto, al MyFirstMap.html
def writeToHTML(htmlString, file = "MyFirstMap.html"):
    try:
        fileHandler = open(file,'w')
        fileHandler.write(htmlString)
        fileHandler.close()
    except IOError:
        print "Error al escribir archivo"

mapaMontevideo = enchulameEseMapa()
writeToHTML(mapaMontevideo.showhtml())


