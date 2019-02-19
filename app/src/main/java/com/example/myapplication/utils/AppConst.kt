package com.example.myapplication.utils


object AppConst {


    internal interface FRGTAG {
        companion object {
            val CreateUserFragment = "CreateUserFragment"
            val LoginUserFragment = "LoginUserFragment"
            val HomeFragment="HomeFragment"
            val FLHAFragment="FLHAFragment"

        }
    }


    internal interface ServerStatus {
        companion object {
            //Server Response Status
            val REQUEST_SUCCESS = "success"
            val REQUEST_ERROR = "error"

            val OK: Short = 200
            val CREATED: Short = 201//
            val ACCEPTED: Short = 202//
            val NON_AUTHORIZE: Short = 203
            val NO_CONTENT: Short = 204//
            val RESET_CONTENT: Short = 205//
            val BAD_REQUEST: Short = 400//
            val UNAUTHORIZED: Short = 401
            val FORBIDDEN: Short = 403
            val DATABASE_NOT_FOUND: Short = 404
            val METHOD_NOT_ALLLOWED: Short = 405
            val NOT_ACCEPTABLE: Short = 406
            val CONFLICT: Short = 409//token expired
            val INTERNAL_SERVER_ERROR: Short = 500
            val BAD_GATEWAY: Short = 502
            val HTTP_VERSION_NOTSUPPORTED: Short = 505
            val NETWORK_ERROR: Short = 0
        }

    }

    internal interface MSG_ERROR {
        companion object {
            //General App messages
            val PREFIX = "Error: "
            val NETWORK = "Please check your Internet connection"

            val ENABLE_LOCATION = "Please enable location from your device"
            val EMAIL = "Please enter valid email"
            val MOBNUM = "Please enter valid mobile number"
            val PASSWORD_EMPTY = "Password field cannot be left empty"
            val PASSWORD_SHORT = "Please enter atleast 6 characters password"
            val PASSWORD_NOMATCH = "Both the passwords donot match"
            val CODE_EMPTY = "Please fill-in the code above, you recieved via SMS"
            val CODE_WRONG = "Please enter the correct code, you recieved via SMS"
            val CONTACTS_SYNC = "Contacts syncing faile.\nPlease retry"
        }
    }


}
