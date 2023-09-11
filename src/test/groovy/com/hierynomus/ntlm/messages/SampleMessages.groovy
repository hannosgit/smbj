/*
 * Copyright (C)2016 - SMBJ Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hierynomus.ntlm.messages

import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_128
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_56
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_ALWAYS_SIGN
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_KEY_EXCH
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_NTLM
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_SEAL
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_SIGN
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_TARGET_INFO
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_UNICODE
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_NEGOTIATE_VERSION
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLMSSP_TARGET_TYPE_SERVER
import static com.hierynomus.ntlm.messages.NtlmNegotiateFlag.NTLM_NEGOTIATE_OEM

interface SampleMessages {
  def serverChallenge = [0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef] as byte[]
  def windowsVersion = new WindowsVersion(WindowsVersion.ProductMajorVersion.WINDOWS_MAJOR_VERSION_6, WindowsVersion.ProductMinorVersion.WINDOWS_MINOR_VERSION_0, 6000, WindowsVersion.NtlmRevisionCurrent.NTLMSSP_REVISION_W2K3)
  def targetName = "Server"

  def ntlmV1NegotiationFlags = EnumSet.of(NTLMSSP_NEGOTIATE_KEY_EXCH, NTLMSSP_NEGOTIATE_56, NTLMSSP_NEGOTIATE_128, NTLMSSP_NEGOTIATE_VERSION, NTLMSSP_TARGET_TYPE_SERVER, NTLMSSP_NEGOTIATE_ALWAYS_SIGN, NTLMSSP_NEGOTIATE_NTLM, NTLMSSP_NEGOTIATE_SEAL, NTLMSSP_NEGOTIATE_SIGN, NTLM_NEGOTIATE_OEM, NTLMSSP_NEGOTIATE_UNICODE)
  def ntlmV1ChallengeMessageBytes = [
    0x4e, 0x54, 0x4c, 0x4d, 0x53, 0x53, 0x50, 0x00, 0x02, 0x00, 0x00, 0x00, 0x0c, 0x00, 0x0c, 0x00,
    0x38, 0x00, 0x00, 0x00, 0x33, 0x82, 0x02, 0xe2, 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    0x06, 0x00, 0x70, 0x17, 0x00, 0x00, 0x00, 0x0f, 0x53, 0x00, 0x65, 0x00, 0x72, 0x00, 0x76, 0x00,
    0x65, 0x00, 0x72, 0x00] as byte[]

  def ntlmV1WithClientChallengeNegotiationFlags = EnumSet.of(NTLMSSP_NEGOTIATE_56, NTLMSSP_NEGOTIATE_VERSION, NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY, NTLMSSP_TARGET_TYPE_SERVER, NTLMSSP_NEGOTIATE_ALWAYS_SIGN, NTLMSSP_NEGOTIATE_NTLM, NTLMSSP_NEGOTIATE_SEAL, NTLMSSP_NEGOTIATE_SIGN, NTLM_NEGOTIATE_OEM, NTLMSSP_NEGOTIATE_UNICODE)
  def ntlmV1WithClientChallengeChallengeMessageBytes = [
    0x4e, 0x54, 0x4c, 0x4d, 0x53, 0x53, 0x50, 0x00, 0x02, 0x00, 0x00, 0x00, 0x0c, 0x00, 0x0c, 0x00,
    0x38, 0x00, 0x00, 0x00, 0x33, 0x82, 0x0a, 0x82, 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    0x06, 0x00, 0x70, 0x17, 0x00, 0x00, 0x00, 0x0f, 0x53, 0x00, 0x65, 0x00, 0x72, 0x00, 0x76, 0x00,
    0x65, 0x00, 0x72, 0x00] as byte[]

  def ntlmV2NegotiationFlags = EnumSet.of(NTLMSSP_NEGOTIATE_KEY_EXCH, NTLMSSP_NEGOTIATE_56, NTLMSSP_NEGOTIATE_128, NTLMSSP_NEGOTIATE_VERSION, NTLMSSP_NEGOTIATE_TARGET_INFO, NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY, NTLMSSP_TARGET_TYPE_SERVER, NTLMSSP_NEGOTIATE_ALWAYS_SIGN, NTLMSSP_NEGOTIATE_NTLM, NTLMSSP_NEGOTIATE_SEAL, NTLMSSP_NEGOTIATE_SIGN, NTLM_NEGOTIATE_OEM, NTLMSSP_NEGOTIATE_UNICODE)
  def ntlmV2ChallengeMessageBytes = [
    0x4e,0x54,0x4c,0x4d,0x53,0x53,0x50,0x00,0x02,0x00,0x00,0x00,0x0c,0x00,0x0c,0x00,
    0x38,0x00,0x00,0x00,0x33,0x82,0x8a,0xe2,0x01,0x23,0x45,0x67,0x89,0xab,0xcd,0xef,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x24,0x00,0x24,0x00,0x44,0x00,0x00,0x00,
    0x06,0x00,0x70,0x17,0x00,0x00,0x00,0x0f,0x53,0x00,0x65,0x00,0x72,0x00,0x76,0x00,
    0x65,0x00,0x72,0x00,0x02,0x00,0x0c,0x00,0x44,0x00,0x6f,0x00,0x6d,0x00,0x61,0x00,
    0x69,0x00,0x6e,0x00,0x01,0x00,0x0c,0x00,0x53,0x00,0x65,0x00,0x72,0x00,0x76,0x00,
    0x65,0x00,0x72,0x00,0x00,0x00,0x00,0x00] as byte[]

  def ntlmV2AuthenticateMessageBytes = [
    0x4e,0x54,0x4c,0x4d,0x53,0x53,0x50,0x00,0x03,0x00,0x00,0x00,0x18,0x00,0x18,0x00,
    0x6c,0x00,0x00,0x00,0x54,0x00,0x54,0x00,0x84,0x00,0x00,0x00,0x0c,0x00,0x0c,0x00,
    0x48,0x00,0x00,0x00,0x08,0x00,0x08,0x00,0x54,0x00,0x00,0x00,0x10,0x00,0x10,0x00,
    0x5c,0x00,0x00,0x00,0x10,0x00,0x10,0x00,0xd8,0x00,0x00,0x00,0x35,0x82,0x88,0xe2,
    0x05,0x01,0x28,0x0a,0x00,0x00,0x00,0x0f,0x44,0x00,0x6f,0x00,0x6d,0x00,0x61,0x00,
    0x69,0x00,0x6e,0x00,0x55,0x00,0x73,0x00,0x65,0x00,0x72,0x00,0x43,0x00,0x4f,0x00,
    0x4d,0x00,0x50,0x00,0x55,0x00,0x54,0x00,0x45,0x00,0x52,0x00,0x86,0xc3,0x50,0x97,
    0xac,0x9c,0xec,0x10,0x25,0x54,0x76,0x4a,0x57,0xcc,0xcc,0x19,0xaa,0xaa,0xaa,0xaa,
    0xaa,0xaa,0xaa,0xaa,0x68,0xcd,0x0a,0xb8,0x51,0xe5,0x1c,0x96,0xaa,0xbc,0x92,0x7b,
    0xeb,0xef,0x6a,0x1c,0x01,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x00,0x00,0x00,0xaa,0xaa,0xaa,0xaa,0xaa,0xaa,0xaa,0xaa,0x00,0x00,0x00,0x00,
    0x02,0x00,0x0c,0x00,0x44,0x00,0x6f,0x00,0x6d,0x00,0x61,0x00,0x69,0x00,0x6e,0x00,
    0x01,0x00,0x0c,0x00,0x53,0x00,0x65,0x00,0x72,0x00,0x76,0x00,0x65,0x00,0x72,0x00,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0xc5,0xda,0xd2,0x54,0x4f,0xc9,0x79,0x90,
    0x94,0xce,0x1c,0xe9,0x0b,0xc9,0xd0,0x3e] as byte[]
}