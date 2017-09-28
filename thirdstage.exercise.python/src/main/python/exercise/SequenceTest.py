'''
Created on 2017. 9. 27.

@author: 3rdstage
'''
import unittest


class Test(unittest.TestCase):


    def setUp(self):
        pass


    def tearDown(self):
        pass


    def testName(self):
        user = ('Paul', 'paul@here.com', '555-123-1234', '010-123-1234')
        name, email, *phone_nums = user
        self.assertEquals(name, 'Paul')


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()