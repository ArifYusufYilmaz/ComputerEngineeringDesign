
import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
export const NoteApiSlice = createApi({
    reducerPath: 'api',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:8080/'}),
    endpoints:(builder)=>({
        getAllNoteSections: builder.query({
              query : ()=> `api/v1/noteSections`   
        }),
        getOneNoteSection:(builder)=>({
            query : (noteSectionId)=> `api/v1/noteSections/${noteSectionId}`
        })
    })
})
export const {
    useGetAllNoteSectionsQuery,
    useGetOneNoteSectionQuery
} = NoteApiSlice