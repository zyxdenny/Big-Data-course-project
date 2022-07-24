import os
import argparse
parser = argparse.ArgumentParser()
parser.add_argument('-f', '--function',type=int, choices=[0,1],help='select function for the program. 0 for getting similar artists within a given distance. 1 for getting the distance between two artists')
parser.add_argument('-m', '--mode',type=int, choices=[0,1],default = 0,help='select mode for the program. 0 for spark. 1 for mapreduce')
parser.add_argument('-i', '--input_id', type=str,
                    help='set the input artist id')
parser.add_argument('-o', '--output_id', type=str,
                    help='set the output artist id')
parser.add_argument('-d', '--distance', type=int, default = 2,
                    help='set the expected distance')


args = parser.parse_args()

function = args.function

if function == 0:
    #get similar artists within a given distance
    if args.input_id == None:
        print("Error, input id unset")
        exit(-1)

    if args.mode == 0:
        #spark
        os.system('pwd')
    else:
        #mapreduce
        os.system('pwd')

if function == 1:
    #get the distance between two artists
    if (args.input_id == None) or (args.output_id == None):
        print("Error, input id/output_id unset")
    exit(-1)

    if args.mode == 0:
        #spark
        os.system('pwd')
    else:
        #mapreduce
        os.system('pwd')