def fun(output, size):
    print("Enter the list of packets")
    ar = [int(x) for x in input().split()]
    for i in range(len(ar)):
        if ar[i] < size:
            if ar[i] <= output:
                print("Packet Number {} with size = {}".format(i, ar[i]))
                print("Bucket output Successful")
                print("Last {} bytes sent".format(ar[i]))
            else:
                print("Packet Number {} with size = {}".format(i, ar[i]))
                print("Bucket output Successful")
                print("{} bytes outputted".format(output))
                s = ar[i] - output
                print("Last {} bytes sent".format(s))
        else:
            print("Packet Number {} with size = {}".format(i, ar[i]))
            print("Bucket Overflow")
        print("*"*20)


output = int(input("Enter output size "))
size = int(input("Enter bucket size "))
fun(output, size)
