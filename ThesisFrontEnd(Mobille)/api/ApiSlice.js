
import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
export const ApiSlice = createApi({
    reducerPath: 'api',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:8080/'}),
    tagTypes:['NoteSections'],
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
        getAllMissions: builder.query({
            query : (noteSectionId)=> `api/v1/missions/all/${noteSectionId}`,


        })
        
    })
})
export const {
    useGetAllNoteSectionsQuery,
    useGetOneNoteSectionQuery,
    useDeleteOneNoteSectionMutation,
    useGetAllMissionsQuery,
    useAddOneNoteSectionMutation,
} = ApiSlice