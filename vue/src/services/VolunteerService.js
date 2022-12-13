import axios from "axios";

export default {
    addVolunteer(volunteer) {
        return axios.post("/volunteer", volunteer);
      },

    getPendingVolunteers() {
        return axios.get('/pendingVolunteers')
      },
    
    getApprovedVolunteers () {
        return axios.get ('/approvedVolunteers')
    },
    
    approveVolunteerStatus(volunteerId){
        return axios.put(`/approveVolunteer/${volunteerId}`)
    },

    rejectVolunteerStatus(volunteerId) {
      return axios.put(`/rejectVolunteer/${volunteerId}`)
    }


    
}