import unittest

class UnpackingTest(unittest.TestCase):
    def testSimplestUnpacking(self):
        seq = (1, 2, 3)
        a, b, c = seq
        self.assertEqual(a, 1)
        self.assertEqual(b, 2)
        self.assertEqual(c, 3)
        
    def testUnpackingNestedCollection(self):
        data = ['Tom', 185, (2001, 11, 23)]
        name, height, (year, month, day) = data
        self.assertEqual(name, 'Tom')
        self.assertEqual(height, 185)
        self.assertEqual(year, 2001)
        self.assertEqual(month, 11)
        self.assertEqual(day, 23)
        
    def testStarUnpacking1(self):
        *past, current = [1, 2, 3, 4, 5, 6, 7]
        self.assertEqual(current, 7)
        self.assertEqual(past, [1, 2, 3, 4, 5, 6])
        
    def testUnpackingWithIgnored(self):
        data = ['Tom', 185, (2001, 11, 23)]
        name, _, (year, *_) = data
        self.assertEqual(name, 'Tom')
        self.assertEqual(year, 2001)