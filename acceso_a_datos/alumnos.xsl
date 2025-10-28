<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Listado de Alumnos</title>
        <style>
          body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #f5f7fa;
            color: #333;
            margin: 40px;
          }
          h2 {
            color: #2b5dff;
            text-align: center;
            margin-bottom: 25px;
          }
          table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
          }
          th {
            background-color: #2b5dff;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            padding: 12px;
            text-align: center;
          }
          td {
            padding: 10px 12px;
            border-bottom: 1px solid #e0e0e0;
            text-align: center;
            vertical-align: middle;
          }
          tr:nth-child(even) {
            background-color: #f0f4ff;
          }
          tr:hover {
            background-color: #dbe3ff;
            transition: 0.2s;
          }
        </style>
      </head>
      <body>
        <h2>Listado de Alumnos</h2>
        <table>
          <tr>
            <th>NIA</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Género</th>
            <th>Fecha de Nacimiento</th>
            <th>Ciclo</th>
            <th>Curso</th>
            <th>Grupo</th>
          </tr>
          <xsl:for-each select="alumnos/alumno">
            <tr>
              <td><xsl:value-of select="nia"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="apellidos"/></td>
              <td><xsl:value-of select="genero"/></td>
              <td><xsl:value-of select="fechaNacimiento"/></td>
              <td><xsl:value-of select="ciclo"/></td>
              <td><xsl:value-of select="curso"/></td>
              <td><xsl:value-of select="grupo"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
