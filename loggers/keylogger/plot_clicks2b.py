#!/usr/bin/python3

import sys

import numpy as np

import os

if 'DISPLAY' not in os.environ:
    import matplotlib
    matplotlib.use("Agg")

import matplotlib.pyplot as plt

#if len(sys.argv) not in [7, 11]:
#    print("Error: Either 6 or 10 arguments expected")
#    sys.exit()

baseline = np.load(sys.argv[1])
#lower_baseline = np.load(sys.argv[2])

#clicka0 = np.load(sys.argv[2])
clicka1 = np.load(sys.argv[2])
clicka2 = np.load(sys.argv[3])
clicka3 = np.load(sys.argv[4])
clicka4 = np.load(sys.argv[5])

#clickb0 = np.load(sys.argv[6])
clickb1 = np.load(sys.argv[6])
clickb2 = np.load(sys.argv[7])
clickb3 = np.load(sys.argv[8])
clickb4 = np.load(sys.argv[9])

#clickc0 = np.load(sys.argv[10])
clickc1 = np.load(sys.argv[10])
clickc2 = np.load(sys.argv[11])
clickc3 = np.load(sys.argv[12])
clickc4 = np.load(sys.argv[13])

#clickd0 = np.load(sys.argv[10])
#clickd1 = np.load(sys.argv[11])
#clickd2 = np.load(sys.argv[12])
#clickd3 = np.load(sys.argv[13])

plt.rc('font', family='Times New Roman')
plt.figure(figsize=(7,4)) 
#fig, (ax0, ax1) = plt.subplots(nrows=2)
#plt.set_size_inches(3.5, 2)

plt.plot(np.arange(1,51), baseline, linewidth=4, label='baseline')
#fig.yaxis.set_ticks(np.arange(0.2, 1.1, 0.2))
plt.title('document precision')
plt.axis([0, 50, 0.3, 0.9])
plt.grid(True)

#ax1.plot(np.arange(1,51), lower_baseline, linewidth=2, label='baseline')
#ax1.yaxis.set_ticks(np.arange(0, 0.55, 0.1))
#ax1.set_title('keywords')
#ax1.axis([0, 50, 0, 0.25])
#ax1.grid(True)

#plt.legend(bbox_to_anchor=(1.1, 1.1))
##ax1.legend(bbox_to_anchor=(1.1, 1.1))
#plt.savefig('foo0.png')
#plt.show()
#sys.exit()

#plt.plot(np.arange(5,16),  clicka0[ 4:15], linewidth=6, c='g')
plt.plot(np.arange(10,21), clicka1[ 9:20], linewidth=6, c='g', label='c=1')
plt.plot(np.arange(20,31), clicka2[19:30], linewidth=6, c='g')
plt.plot(np.arange(30,41), clicka3[29:40], linewidth=6, c='g')
plt.plot(np.arange(40,51), clicka4[39:50], linewidth=6, c='g')

#plt.plot(np.arange(5,16),  clickb0[ 4:15], linewidth=6, c='r')
plt.plot(np.arange(10,21), clickb1[ 9:20], linewidth=6, c='r', label='c=0')
plt.plot(np.arange(20,31), clickb2[19:30], linewidth=6, c='r')
plt.plot(np.arange(30,41), clickb3[29:40], linewidth=6, c='r')
plt.plot(np.arange(40,51), clickb4[39:50], linewidth=6, c='r')

#plt.plot(np.arange(5,16),  clickc0[ 4:15], linewidth=6, c='c')
plt.plot(np.arange(10,21), clickc1[ 9:20], linewidth=6, c='c', label='c=5')
plt.plot(np.arange(20,31), clickc2[19:30], linewidth=6, c='c')
plt.plot(np.arange(30,41), clickc3[29:40], linewidth=6, c='c')
plt.plot(np.arange(40,51), clickc4[39:50], linewidth=6, c='c')

#plt.plot(np.arange(10,21), clickd0[ 9:20], linewidth=6, c='m', label='cont-cur')
#plt.plot(np.arange(20,31), clickd1[19:30], linewidth=6, c='m', label='cont-old')
#plt.plot(np.arange(30,41), clickd2[29:40], linewidth=6, c='m', label='cont-old')
#plt.plot(np.arange(40,51), clickd3[39:50], linewidth=6, c='m', label='cont-old')

#plt.plot(np.arange(10,21), clickb0[ 9:20], lw=6, ls='--', c='g', label='cont-cur')
#plt.plot(np.arange(20,31), clickb1[19:30], lw=6, ls='--', c='r', label='cont-old')
#plt.plot(np.arange(30,41), clickb2[29:40], lw=6, ls='--', c='c', label='cont-old')
#plt.plot(np.arange(40,51), clickb3[39:50], lw=6, ls='--', c='m', label='cont-old')

# ax0.legend(bbox_to_anchor=(1.1, 1.1))
# #ax1.legend(bbox_to_anchor=(1.1, 1.1))
# plt.savefig('foo1.png')
# plt.show()
# sys.exit()

plt.legend(loc=4, borderaxespad=0.)

# if len(sys.argv) > 7:

#     exp_cur = np.load(sys.argv[7])
#     lower_exp_cur = np.load(sys.argv[8])
    
#     exp_old = np.load(sys.argv[9])
#     lower_exp_old = np.load(sys.argv[10])

#     ax0.plot(exp_cur, linewidth=3, label='exp-cur')
#     ax1.plot(lower_exp_cur, linewidth=3, label='exp-cur')
#     ax0.plot(exp_old, linewidth=3, label='exp-old')
#     ax1.plot(lower_exp_old, linewidth=3, label='exp-old')

#ax0.legend(bbox_to_anchor=(1.1, 1.1))
#ax1.legend(bbox_to_anchor=(1.1, 1.1))

plt.tight_layout()
plt.savefig('foo.png')
plt.show()
sys.exit()