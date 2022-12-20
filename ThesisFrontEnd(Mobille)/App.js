import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import ApiExample from './components/ApiExample';
import Router from './routers/Router';


import { ApiProvider } from '@reduxjs/toolkit/dist/query/react';
import { NoteApiSlice } from './api/NoteApiSlice';



export default function App() {
  return (
    <ApiProvider api = {NoteApiSlice}>
        <View style={styles.container}>
          {/* <ApiExample></ApiExample> */}
          {/* <Text>Open up App.js to start working on your app!</Text> */}
          <Router></Router>
        </View>
    </ApiProvider>
  );
}   

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
