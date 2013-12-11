<?xml version="1.0" encoding="utf-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron">
<title>Schematron for Service Meta</title>
<ns prefix="svc" uri="http://www.thirdstage.org/example/ns/service"/>
<pattern>
	<rule context="svc:simple[@min-length][@max-length]">
		<report test="@max-length/string() > @min-length/string()">
		Teh max-length should be equal or greater than min-length.
		</report>
	</rule>
</pattern>
</schema>