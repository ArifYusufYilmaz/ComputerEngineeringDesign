
import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
export const ApiSlice = createApi({
    reducerPath: 'ApiSlice',
    baseQuery : fetchBaseQuery({baseUrl : 'http://192.168.1.6:8080/'}),
    tagTypes:['NoteSections', 'Missions', 'Tasks', 'Users'],
    endpoints:(builder)=>({
        getAllNoteSections: builder.query({
              query : (userId)=> `api/v1/noteSections/all/userId/${userId}` ,
              providesTags: ['NoteSections'] 
        }),
        getOneNoteSection:(builder)=>({
            query : (noteSectionId)=> `api/v1/noteSections/noteSection/${noteSectionId}`
        }),
        addOneNoteSection : builder.mutation({
            query : (noteSection) => ({
                url:`api/v1/noteSections/userId/${noteSection.userId}`,
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
                url: `api/v1/missions/noteSectionId/${mission.noteSectionId}`,
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
                url: `api/v1/tasks/missionId/${task.missionId}`,
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
        signUpUser : builder.mutation({
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
    useSignUpUserMutation,
    useLoginUserMutation,
} = ApiSlice