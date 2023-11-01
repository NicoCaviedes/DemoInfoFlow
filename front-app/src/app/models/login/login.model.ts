import { UserModel } from "../user/user.model";

export interface LoginModelApi{
    respuesta: string,
    usuario: UserModel | undefined,
}