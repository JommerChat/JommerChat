export interface Guild {
  id: BigInteger;
  createdAt: string;
  name: string;
  description?: string;
  image?: string;
  publicFlag?: boolean;
}
