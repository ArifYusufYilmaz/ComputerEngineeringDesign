
import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
export const ApiSlice = createApi({
    reducerPath: 'ApiSlice',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:8080/'}),
    tagTypes:['NoteSections', 'Missions', 'Tasks', 'Users'],
    endpoints:(builder)=>({
        getAllNoteSections: builder.query({
              query : ()=> `api/v1/noteSections` ,
              providesTags: ['NoteSections'] 
        }),
        getOneNoteSection:(builder)=>({
            query : (noteSectionId)=> `api/v1/noteSections/${noteSectionId}`
        }),
        addOneNoteSection : builder.mutation({
            query : (noteSection) => ({
                url:`api/v1/noteSections`,
                method: 'POST',
                body: noteSection
            }),
            invalidatesTags:['NoteSections']
        }),
        deleteOneNoteSection: builder.mutation({
            query: (noteSectionId) => ({
                url : `api/v1/noteSections/${noteSectionId}`,
                method: 'DELETE',
                body: noteSectionId
            }),
            invalidatesTags:['NoteSections']

        }),
        // updateNoteSection
        getAllMissions: builder.query({
            query : (noteSectionId)=> `api/v1/missions/all/${noteSectionId}`,
            providesTags : ['Missions']
        }),
        addOneMission : builder.mutation({
            query : (mission) =>({
                url: `api/v1/missions/${mission.noteSectionId}`,
                method: 'POST',
                body: mission
            }),
            invalidatesTags: ['Missions']
        }),
        deleteOneMission: builder.mutation({
            query : (missionId) => ({
                url: `api/v1/missions/${missionId}`,
                method: 'DELETE',
                body:missionId
            }),
            invalidatesTags:['Missions']
        }),
        //getOneMission,
        //updateOneMission
        getAllTasks : builder.query({
            query : (missionId)=> `api/v1/tasks/all/${missionId}`,
            providesTags : ['Tasks']
        }),
        addOneTask : builder.mutation({
            query : (task)=>({
                url: `api/v1/tasks/${task.missionId}`,
                method:'POST',
                body: task
            }),
            invalidatesTags : ['Tasks']
        }),
        deleteOneTask: builder.mutation({
            query: (taskId)=>({
                url: `api/v1/tasks/${taskId}`,
                method : 'DELETE',
                body : taskId
            }),
            invalidatesTags : ['Tasks']
        }),
        //
        getOneUser : builder.query({
            query : (userId) => `api/v1/users/${userId}`,
            providesTags : ['Users']
        }),
        addOneUser : builder.mutation({
            query : (user)=>({
                url:`api/v1/users/signUp`,
                method:'POST',
                body: user
            }),
            invalidatesTags : ['Users']
        }),
        loginUser : builder.mutation({
            query : (user)=> ({
                url : `api/v1/users/login`,
                method : 'POST',
                body : user
            }),
            invalidatesTags: ['Users']
        })
    })
})
export const {
    useGetAllNoteSectionsQuery,
    useGetOneNoteSectionQuery,
    useDeleteOneNoteSectionMutation,
    useGetAllMissionsQuery,
    useAddOneNoteSectionMutation,
    useAddOneMissionMutation,
    useDeleteOneMissionMutation,
    useGetAllTasksQuery,
    useAddOneTaskMutation,
    useDeleteOneTaskMutation,
    useGetOneUserQuery,
    useAddOneUserMutation,
    useLoginUserMutation,
} = ApiSlice