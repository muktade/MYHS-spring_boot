# MYHS-spring_boot

############################
---------------------------

git clone https://yasiraraphat@bitbucket.org/yasiraraphat/test.git

<br>
<hr>

tables
--------
*base={
id:Long,
isActive: Boolen;
isApproved: Boolen;
}

1. user={
name:String;
username:String;
password: String;
role: Role[];
email:String;
address: String;
phone:String;
}

2.Role={
name:String;
}

3.propertyType={
name:String;
type:String;
}

4.property={
usr-id:
name:String;
propertyType:PropertyType;
price:Double;
size: String;
photo: Photo[];
paymentFrequency:Enum;
completionStatus:String;
isNagotiable:Boolen;
location:String;
facing:Enum;
description:String;
publisingDate:Date;
}

5.photo={
name:String;
data:String;
}

6.comments={
user-id:
property-id:
reply:Reply[];
text:String;
date:Date;
}

7.reply={
comment-id:
text:String;
user-id:
date:Date;
}

8.chatHistory={
fromUserId:
toUserId:
message:String;
}
9.district{
division:EDivision;
name:String;
}
10.Enum-division={
name:String;
}
11.city={
name:String;
district:Distric;
}
12.area={
name:String;
district:District;
postCode:String;
}

e-paymentFrequence={
Daily
Monthly,
Yearly,
}
e-facing={
North,
dik-all
}


