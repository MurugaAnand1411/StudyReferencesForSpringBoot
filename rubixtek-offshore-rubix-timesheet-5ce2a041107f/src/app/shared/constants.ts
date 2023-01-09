import { NavItem } from "./model/nav-item";



export class constants {
  public static AppName = "Timesheet";
  public static ErrorOccurInClientside = " Error Occur in Client Side";
  public static AnUnexceptedErrorOccured = "An Unexcepted Error Occured";
  public static AddressDeletedSuccessfully = "Address Deleted Successfully";
  public static AddressAddedSuccessfully = "Address Added Successfully";
  public static AddressUpdatedSuccessfully = "Address Updated successfully";
  public static PleaseEnterValidEmailidAndPassword = "Please Enter Valid Emailid and Password";
  public static InvalidCredentialsPleaseEnterValidEmailidAndPassword = "Invalid Credentials Please Enter Valid Emailid and Password";
  public static PasswordShouldContainOneSpecialCharacter = "Password should contain one special character, one number,one Upper case,one lower case and minimum length of 8 (Eg:- Rubix@123)";
  public static SignUpSuccessfullyDone = "Sign Up successfully Done \n Please verify your emailId";
  public static SignUpSuccessfully = "Sign Up Successfully";
  public static AlphaNumericRegEx = "[a-zA-Z][a-z.A-Z0-9 ]{2,}";
  public static NumericRegEx = "^[0-9]{1,}";
  public static CardNumberRegEx = "^[0-9]{10,}";
  public static CvvNumberRegEx = "^[0-9]{3}";
  public static NumberRegEx = "[+0-9-)( ][-0-9)(]{2,30}";
  public static ServerSideError = "Server Side Error";
  public static ProductToCart="Product Added to Cart";
  public static AddressListTitle="Manage Address";
  public static AddIcon="add_box";
  public static AddressAddTitle="Add Address";
  public static AddressUpdateTitle="Edit Address";
  public static SaveIcon="save";
  public static CartTitle="My Cart";
  public static CartIcon="add_shopping_cart";
  public static FarmerDetailTitle="Farmer Detail";
  public static FarmerIcon="add_shopping_cart";
  public static FarmerListTitle="Farmers List";
  public static SubscribedItemSuccessfully = "Subscribed Item Successfully";
  public static SubscribedItemCancelledSuccessfully="Subscribed Item Cancelled"
  public static AddedItemIntoCartSuccessfully = "Added Item Into Cart Successfully";
}

export const errorMessages: { [key: string]: string } = {
  emailId:'Email Id is required',
  validEmail:'Enter a valid Email Id',
  password:'Password is required',
  required: ' is required',
  valid: 'Enter a valid ',
  confirmpassword: 'Password do not match',
  emailexist: 'Email Id already exists',
};

export const sideNavigationMenu: NavItem[] =
  [
    {
      displayName: 'Home',
      iconName: 'home',
      route: '/dashboard',
      children: [
        // {
        //   displayName: 'Timesheet',
        //   iconName: 'pending_actions',
        //   route: '/timesheet',
        // },
      ]
    },
    // {
    //   displayName: 'Leave',
    //   iconName: 'person',
    //   route: '/account',
    // },
    // {
    //   displayName: 'Timesheet',
    //   iconName: 'pending_actions',
    //   route: '/timesheet',
    // },
    // {
    //   displayName: 'Report',
    //   iconName: 'tab',
    //   route: '/timesheet',
    // },
    
    
  ];

