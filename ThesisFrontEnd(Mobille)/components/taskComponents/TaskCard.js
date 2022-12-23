import React from 'react';
import { Text, View } from 'react-native';

export default function TaskCard(props){
    const taskName = props.task.taskName;
    const taskId = props.task.id
    return(
        <View>
            <Text>
                hi task card {taskId} {taskName}
            </Text>
        </View>
    );
}