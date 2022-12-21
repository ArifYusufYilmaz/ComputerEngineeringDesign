import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query";

export const MissionApiSlice = createApi({
    reducerPath: 'api',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:8080/'}),
    endpoints: (builder)=>({
        getAllMissions: builder.query({
            query : (noteSectionId)=> `api/v1/missions/all/${noteSectionId}`
        })
    })


})

export const {
    useGetAllMissionsQuery
} = MissionApiSlice