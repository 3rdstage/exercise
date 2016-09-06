from pybuilder.core import use_plugin
from pybuilder.core import init

use_plugin("python.core")
use_plugin("python.unittest")
use_plugin("python.coverage")
use_plugin("python.distutils")
use_plugin('python.pydev')

default_task = "publish"

@init
def initialize(project):
    project.set_property('dir_source_main_python', 'src/main/python')
    project.set_property('dir_source_main_scripts', 'src/main/scripts')
    project.set_property('dir_source_unittest_python', 'src/test/python')