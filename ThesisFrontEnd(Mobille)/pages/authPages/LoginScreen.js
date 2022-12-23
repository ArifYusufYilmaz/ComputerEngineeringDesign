import React, { useState } from "react";
import { ActivityIndicator, Button, StyleSheet, Text, TextInput, View } from "react-native";
import {Formik} from 'formik';
import Toast from 'react-native-toast-message';

import { useAddOneUserMutation } from "../../api/ApiSlice";


const initialFormValues = {
    userfirstname: '',
    userlastname:'',
    email:'',
    password:'',
}

export default function LoginScreen(props){
    const [loading, setLoading] = useState(false);

    const [addOneUser, error] = useAddOneUserMutation();

    function handleNavigateToSignup(){
        props.navigation.navigate("SignUp")
    }
    function handleFormSubmit(formValues){
         const userObject = {"userFirstName" : formValues.userfirstname,
                             "userLastName" : formValues.userlastname,
                            "userEmail": formValues.email,
                            "userPassword": formValues.password}

          setLoading(true)
        
          addOneUser(userObject)
                                .unwrap()
                                .then((payload) =>   Toast.show({
                                                                       type: 'success',
                                                                       text1: "Kullanıcı Eklendi!  "+payload.data.userFirstName ,
                                                                       position:"top",
                                   })).
                                    catch((error) => Toast.show({  
                                                                 type: 'error',
                                                                 text1: "HATALI İŞLEM!  " + error.data.data.message,
                                                                 position:"top",
                                                              }));
            
          setLoading(false)
       
    }
    return(
        <View>
            <Formik initialValues={initialFormValues} onSubmit={handleFormSubmit}>
            {({values, handleChange, handleSubmit}) =>
             <>
                <TextInput placeholder="userfirstname" value={values.firstname} onChangeText={handleChange('userfirstname')} />
                <TextInput placeholder="userlastname" value={values.lastname} onChangeText={handleChange('userlastname')} />
                <TextInput placeholder="email" value={values.email} onChangeText={handleChange('email')}></TextInput>
                <TextInput placeholder="password" value={values.password} onChangeText={handleChange('password')} secureTextEntry={true}/>
                <Button title={loading ? <ActivityIndicator/> : "Log In"} onPress={handleSubmit}/>
            </>
            }
            </Formik>
           
            <Button title="SIGN UP" onPress={handleNavigateToSignup}></Button>

        </View>
    );
}
const styles = StyleSheet.create({
    
   
})