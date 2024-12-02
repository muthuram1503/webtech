<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <title>MNC COMPANIES</title>
            </head>
            <body>
                <h1>TOP COMPANIES</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Clients count</th>
                            <th>Company Profit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="companies/company">
                            <tr>
                                <td><xsl:value-of select="id" /></td>
                                <td><xsl:value-of select="name" /></td>
                                <td><xsl:value-of select="count" /></td>
                                <td><xsl:value-of select="Profit" /></td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
