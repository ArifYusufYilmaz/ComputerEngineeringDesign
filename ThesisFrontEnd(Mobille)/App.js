import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import ApiExample from './components/ApiExample';
import Router from './routers/Router';
import Toast from 'react-native-toast-message';


import { ApiProvider } from '@reduxjs/toolkit/dist/query/react';
import { ApiSlice } from './api/ApiSlice';

import store from './globalStates/store';
import { Provider } from 'react-redux';



export default function App() {

  return (
    // <ApiProvider api = {ApiSlice} >
      <Provider store={store}>
        <View style  = {styles.container}>
          {/* <ApiExample></ApiExample> */}
          {/* <Text>Open up App.js to start working on your app!</Text> */}
          <Router></Router>
        </View>
        <Toast/>
      </Provider>
     
    // </ApiProvider>
  );
}   

const styles = StyleSheet.create({
   container: {
     flex: 1,
  //   backgroundColor: '#fff',
  //   alignItems: 'center',
  //   justifyContent: 'center',
   },
});
