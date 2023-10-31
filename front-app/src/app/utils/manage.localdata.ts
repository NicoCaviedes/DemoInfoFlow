import { UserModel } from "../models/user/user.model";

export class ManageLocalData {

    static saveExistsLocalData(userData: UserModel){
        localStorage.clear();
        localStorage.setItem('userdata', JSON.stringify(userData));
    }

    static saveLoginLocalData(userModel: UserModel): void{
        localStorage.clear();
        localStorage.setItem('userdata', JSON.stringify(userModel));
    }

    static getLocalData(): UserModel{
        return JSON.parse(localStorage.getItem('userdata') || '{}');
    }
}