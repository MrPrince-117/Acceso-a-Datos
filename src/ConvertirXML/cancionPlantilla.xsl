<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/Canciones">
        <html>
            <head>
                <title>Lista de Canciones</title>
            </head>
            <body>
                <h1>Lista de Canciones</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Artista</th>
                        <th>Duración</th>
                        <th>Escuchada</th>
                    </tr>
                    <xsl:apply-templates select="Cancion"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Cancion">
        <tr>
            <td><xsl:value-of select="datoCanciones[1]"/></td>
            <td><xsl:value-of select="datoCanciones[3]"/></td>
            <td><xsl:value-of select="datoCanciones[4]"/></td>
            <td><xsl:value-of select="datoCanciones[5]"/></td>
            <td><xsl:value-of select="datoCanciones[6]"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>