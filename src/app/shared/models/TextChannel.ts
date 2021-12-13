import {Guild} from './Guild';

export interface TextChannel {
  id: string;
  createdAt: string;
  guildEntity: Guild;
  title: string;
  description: string;
}
