

import unittest
import numpy as np

class Test(unittest.TestCase):

  def setUp(self):
    pass

  def tearDown(self):
    pass

  def testDimensionAndShape(self):
    arr = np.array([[1, 2, 3], [4, 5, 6]])

    self.assertEquals(2, arr.ndim)

  def testAccessElementOfMultiDimensionalArray(self):
    arr = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])

    self.assertEquals(arr[0][1][0], 3)
    self.assertEquals(arr[1][1][0], 7)


  def testMultiDimensionalArraySlicing(self):

    arr = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]])

    arr2 = arr[::2]
    print(arr2)

    self.assertEqual(arr2.shape[0], 2)
    self.assertEqual(arr2.shape, (2, 5))
    self.assertIn(arr[0], arr2)
    self.assertNotIn(arr[1], arr2)
    self.assertIn(arr[2], arr2)

