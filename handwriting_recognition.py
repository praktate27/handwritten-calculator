__author__ = 'praktate'
# This file is to recoginize handwritten digits. 
# IMPORTANT: You should change the path in the readtrain method before running this file.
# 1. transform the strings into 28*28 matrix,
# 2. read the training set,
# 3. use One-Nearest Neighborhood algorithm to match the digits the user writes with the training set and get the result

import struct
import numpy as np
import math
import random
import sys

class Solution():
    def __init__(self):
        self.trainimgset=None
        self.trainimglab=None
        self.testimglab=None
        self.testimgset=[] # None
        self.numTrainImg=0
        self.numTestImg=0
        self.subsetimg=[]
        self.numSubImg=0
        self.subsetlab=[]
        self.new = []

    def str_to_matrix(self):
        i = 1
        while i<=784:
            if i%28==1:
                self.new.append([])
            self.new[-1].append(int(sys.argv[i]))
            i+=1
        self.new = np.asmatrix(self.new)

    def readfile(self,imgfile,labfile,numImg):

        binfile_img=open(imgfile,'rb')
        buffer_img=binfile_img.read()
        binfile_img.close()

        binfile_lab=open(labfile,'rb')
        buffer_lab=binfile_lab.read()
        binfile_img.close()

        imageset=[]
        lableset=[]
        index_img=16
        index_lab=8

        for i in range(numImg):
            im = struct.unpack_from('>784B' ,buffer_img, index_img)
            index_img += 784

            im = np.array(im)
            im = im.reshape(28,28)

            imageset.append(im)

            lable=struct.unpack_from('>784B' ,buffer_lab, index_lab)
            index_lab+=1
            lableset.append(lable[0])
        return imageset, lableset

    # Read the training set. Call the readfile method to do it
    def readtrain(self,numread):
        # Need to change path according to your location of images
        self.imgfile='/Users/prachi/git/handwritten-calculator/database/train-images.idx3-ubyte' 
        self.labfile='/Users/prachi/git/handwritten-calculator/database/train-labels.idx1-ubyte'
        self.trainimgset,self.trainimglab=self.readfile(self.imgfile,self.labfile,numread)# 2 is the number of image I want to read
        self.numTrainImg=len(self.trainimgset)
        return

    # Method is used to select subset of trainingset randomly.
    # Decides how many samples in training set should be read. Time consuming
    def findRandomSubset(self):
        numTS = 20000 # Number can vary from 0 to 55000. But higher the number of set, better accuracy but more time consumption 
        self.readtrain(numTS)
        self.subsetimg=[]
        self.numSubImg=numTS
        self.subsetlab=[]

        self.subsetimg = self.trainimgset
        self.subsetlab = self.trainimglab

    def new_match(self):
        # image, imgset, labelset
        distance = []
        temp = np.zeros(self.new.shape, dtype= np.float32)
        for img in self.subsetimg:
            temp = img
            d = np.square(temp-self.new).sum()
            distance.append(d)
        index = np.argmin(distance)
        print self.subsetlab[index]

if __name__ == "__main__":
    c=Solution()
    c.str_to_matrix()
    c.findRandomSubset()
    c.new_match()
