#include<stdio.h>
#include<conio.h>
void main()
{
int i,j,,temp,a[100],n;
printf("Enter no of elemnts to enter");
scanf("%d",&n);
printf("Enter a no");
scanf("%d",&a[0]);
printf("Enter a no");
for(k=0;k<=n-1;k++)
{
scanf("%d",&a[k]);
for(i=0;i<=k-1;i++)
{
for(j=i+1;j<=k-2;j++)
{
if (a[i]>a[j])
{
temp=a[i];
a[i]=a[j];
a[j]=temp;
}
}
}
}
printf("The ordered list is");
for(i=0;i<n-1;i++)
{
printf("%d",a[i]);
}
}