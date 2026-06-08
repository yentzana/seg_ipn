#!/bin/sh

VERSION_TEMPORAL=".$1.$2"
RUTA_ARCHIVO="gradle.properties"
PROPIEDAD="version"
sed -i -e 's/\r//' -e "s/$PROPIEDAD=.*/&$VERSION_TEMPORAL/" $RUTA_ARCHIVO
VERSION_SONAR=`cat $RUTA_ARCHIVO | grep ${PROPIEDAD} | cut -d '=' -f2 | tr -d '\r'`
echo "version sonarQube $VERSION_SONAR"
