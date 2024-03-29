import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function TaskCard(props){
    const taskName = props.task.taskName;
    const taskId = props.task.id
    return(
        <View>
            <Text style={styles.textStyle}>
                {taskName}
            </Text>
        </View>
    );
}
const styles = StyleSheet.create({
    textStyle:{
        fontSize: 25,
    }
})