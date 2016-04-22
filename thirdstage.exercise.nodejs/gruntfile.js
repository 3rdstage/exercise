module.exports = function(grunt){

	grunt.initConfig({
		clean : ['temp', 'target']
	});

	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.registerTask('default', ['clean']);

}