import unittest

class CollectionTest(unittest.TestCase):
    def testList1(self):
        fruits = ['apple', 'mango', 'kiwi', 'water melon', 'banana', 'orange', 'apple', 'apple']
        n0 = len(fruits)
        self.assertEquals(fruits.pop(), 'apple')
        self.assertEquals(len(fruits), n0 - 1)
        fruits.remove('apple')
        self.assertEquals(len(fruits), n0 - 2)
        self.assertEquals(fruits[0], 'mango')
        self.assertEquals(fruits[-1], 'apple')
    
    def testEmptyList1(self):
        fruits = [] # empty list
        with self.assertRaises(IndexError):
            none = fruits[-1]