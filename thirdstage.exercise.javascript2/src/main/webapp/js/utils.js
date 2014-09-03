(function(window, undefined) {
	"use strict";

	var	utils = {};

	utils.normalizeXmlTags = function(str){

		var str1, str2;
		var re, re1, re2;
		var result;

		//normalize start tag including attribute values
		//refer http://www.w3.org/TR/REC-xml/#AVNormalize
		//the most common form of xs:name : [A-Za-z_:][-\w:.]+ (http://www.w3.org/TR/xml/#d0e804)
		re1 = /<\s*([A-Za-z_:][-\w:.]+)([^<>]*[^\/<>])?(\/)?>/g;
		re2 = /\s*([A-Za-z_:][-\w:.]+)\s*=\s*(?:"([^"]*)"|'([^']*)')/g;

		str1 = str.replace(re1, function(match, p1, p2, p3, offset, string) {
			p2 = (p2 || "").trim();

			str2 = p2.replace(re2, function(match, p1, p2, p3, offset, string) {
				result = " " + p1 + "=";
				// only one of p2 or p3 always undefined
				if (p2) {
					result += "\"" + p2.trim() + "\"";
				} else if (p3) {
					result += "'" + p3.trim() + "'";
				} else {/*error */ }

				return result;
			});

			return "<" + p1 + str2 + (p3 || "") + ">";
		});

		//normalize the end tag
		re = /<\/\s*([A-Za-z_:][-\w:.]+)\s*>/g;
		return str1.replace(re, "</$1>");
	};


	window.app = window.app || {};
	window.app.utils = utils;

}(window));