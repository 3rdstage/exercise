<?xml version="1.0" encoding="utf-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron">
<title>Schematron for Service Meta</title>
<ns prefix="svc" uri="http://www.thirdstage.org/example/ns/service"/>
<pattern>
	<rule context="//svc:simple[@min-length][@max-length]">
		<assert test="@max-length/number() &gt; @min-length/number()">
		The max-length should be equal or greater than min-length.
		</assert>
	</rule>
</pattern>
</schema>