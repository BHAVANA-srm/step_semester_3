import java.util.*;
class evenodd{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no.of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("enter element:");
            arr[i]=sc.nextInt();       
        }
        int even=0,odd=0;
        for(int i=0;i<n;i++){
            if(arr[i] % 2 ==0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("even count "+even+" odd count "+odd);
    }
}