'''
Created on 2017. 9. 27.

@author: 3rdstage
'''
import unittest
import collections


class Test(unittest.TestCase):


    def setUp(self):
        pass


    def tearDown(self):
        pass


    def testUnpacking(self):
        user = ('Paul', 'paul@here.com', '555-123-1234', '010-123-1234')
        name, email, *phone_nums = user
        self.assertEquals(name, 'Paul')
        self.assertEquals(email, 'paul@here.com')
        self.assertEquals(phone_nums[0], '555-123-1234')
        self.assertEquals(phone_nums[1], '010-123-1234')

        grades = (90, 95, (95, 80, 100))
        math, eng, (art, music, history) = grades
        self.assertEquals(math, 90)
        self.assertEquals(eng, 95)
        self.assertEquals(art, 95)
        self.assertEquals(music, 80)
        self.assertEquals(history, 100)

    def testDedupe(self):
        points = [{'x': 1, 'y': 2}, {'x': 1, 'y': 3}, {'x': 1, 'y': 2}, {'x': 2, 'y': 2}]

        keyMapper = lambda v: (v['x'],v['y'])
        keys = set()
        distinct = list()
        for pt in points:
            key = keyMapper(pt)
            if key not in keys:
                distinct.append(pt)
                keys.add(key)

        self.assertEquals(len(distinct), 3)

    def testSlice(self):

        two2four = slice(2, 4) # 0-based, 1st argument is inclusive and 2nd is exclusive

        items = [1, 2, 3, 4, 5, 6, 7, 9, 10]
        sliced = items[two2four]

        self.assertEquals(sliced, [3, 4])

    def testCounter(self):
        words = ["every", "breath", "you", "take", "every", "move", "you", "make"
                 , "every", "bond", "you", "break", "every", "step", "you", "take", "I'll", "watching", "you"]

        wordCounter = collections.Counter(words)
        top3 = wordCounter.most_common(3)

        self.assertEquals([top3[0][0], top3[1][0]], ["you", "every"])
        self.assertEquals([wordCounter["take"], wordCounter["make"]], [2, 1])



if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()