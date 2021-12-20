import {Member} from './Member';
import {TextChannel} from './TextChannel';
import {VoiceChannel} from './VoiceChannel';
import {Messages} from './Messages';

export interface GuildInfo {
  members: Member;
  textChannels: TextChannel[];
  voiceChannels: VoiceChannel[];
  currentTextChannelIndex: number;
  messagesForCurrentChannel: Messages[];
}
