import {Guild} from './Guild';

export interface VoiceChannel {
  id: BigInteger;
  createdAt: string;
  guildEntity: Guild;
  title: string;
}
