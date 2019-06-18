import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/MedClassify/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/MedClassify/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/MedClassify/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}